package springapp.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

@Service
public class UnixManager {
	Session session;
	JSch jsch;
	protected final Log logger = LogFactory.getLog(getClass());
	private String output;
	private InputStream in;
	private OutputStream out;
	private PrintStream ps;

	public String getOutput(final String command) {
			try {

				jsch = new JSch();

				try {
					session = jsch.getSession("Ankur", "localhost", 22);
				} catch (JSchException e) {
					e.printStackTrace();
				}
				session.setPassword("0");
				Properties config = new Properties();
				config.put("StrictHostKeyChecking", "no");
				session.setConfig(config);
				try {
					session.connect(3000);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				output = "";
				Channel channel = session.openChannel("exec");
				((ChannelExec) channel).setCommand(command);
				channel.setInputStream(null);
				// OutputStream out=channel.getOutputStream();
				InputStream in = channel.getInputStream();
				channel.connect();

				logger.info("channel connected: " + channel.isConnected());
				logger.info("command written");
				byte[] temp = new byte[1024];
				while (true) {
					logger.info("channnel: " + channel.isConnected());
					logger.info("available: " + in.available());
					while (in.available() > 0) {
						int i = in.read(temp, 0, 1024);
						logger.info(i);
						if (i < 0)
							break;
						output = output + new String(temp, 0, i);
					}
					
					
					if (channel.isClosed()) {
						logger.info("exit status" + channel.getExitStatus());
						break;
					}

					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				channel.disconnect();
				session.disconnect();
				return output;
			} catch (Exception e) {
				e.printStackTrace();
				return e.toString();
			}
		} 
	@PostConstruct
	private void startServer() {
		// TODO Auto-generated method stub

	}

}

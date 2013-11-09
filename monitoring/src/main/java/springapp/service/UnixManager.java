package springapp.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;
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
public class UnixManager{
	Session session;
	JSch jsch;
	private PrintWriter stdin;
	private BufferedReader br;
	protected final Log logger = LogFactory.getLog(getClass());

	public String getOutput(final String command) {
		if (session.isConnected()) {
			try {
				Channel channel = session.openChannel("exec");
				((ChannelExec) channel).setCommand(command);
				
				final PipedInputStream pis = new PipedInputStream();
				channel.setOutputStream(new PipedOutputStream(pis));
				
				logger.info("channel connected: " + channel.isConnected());
				// TODO Auto-generated method stub
				channel.connect(3000);
				new Thread(new Runnable() {
					public void run() {
						try {
							int i=0;
							while ((i = pis.read()) != -1) {
								char c = (char) i;
								System.out.print(c);
							}
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start();
				Thread.sleep(1000);
				
				
				
				return command;
			} catch (Exception e) {
				e.printStackTrace();
				return e.toString();
			}
		} else {
			startServer();
			return "server not connected";
		}
	}

	@PostConstruct
	private void startServer() {
		// TODO Auto-generated method stub
		jsch = new JSch();

		try {
			session = jsch.getSession("Ankur", "localhost", 22);
		} catch (JSchException e) {
			e.printStackTrace();
		}
		session.setPassword("0");
		// Create UserInfo instance in order to support SFTP connection to any
		// machine
		// without a key username and password will be given via UserInfo
		// interface.
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		try {
			session.connect(3000);
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(session.isConnected());
	} 	

}

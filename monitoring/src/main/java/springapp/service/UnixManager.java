package springapp.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

@Service
public class UnixManager {
	Session session;
	JSch jsch;
	private PrintWriter stdin;
	private BufferedReader br;

	public String getOutput(final String command) {
		try {
			stdin.write(command);
			return br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
	}

	@PostConstruct
	private void startServer() {
		// TODO Auto-generated method stub
		jsch = new JSch();

		try {
			session = jsch.getSession("a534230", "freeshell.org", 22);
		} catch (JSchException e) {
			e.printStackTrace();
		}
		session.setPassword("Urmila11");
		// Create UserInfo instance in order to support SFTP connection to any
		// machine
		// without a key username and password will be given via UserInfo
		// interface.
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);

		try {
			session.connect(1000);

			Channel channel = session.openChannel("shell");
			channel.connect();
			final PipedOutputStream pos = new PipedOutputStream();
			channel.setInputStream(new PipedInputStream(pos));
			stdin = new PrintWriter(new OutputStreamWriter(pos, "utf-8"));

			PipedInputStream pis = new PipedInputStream();
			channel.setOutputStream(new PipedOutputStream(pis));
			br = new BufferedReader(new InputStreamReader(pis, "utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.print(session.isConnected());

	}

}

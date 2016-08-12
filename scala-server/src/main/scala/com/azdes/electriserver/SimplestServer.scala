package com.azdes.electriserver;

import org.eclipse.jetty.server.Server;

/**
 * The simplest possible Jetty server.
 */
object SimplestServer {
	def main(args: Array[String]) {
        val server = new Server(8080);
        server.start;
        server.dumpStdErr;
        server.join;
    }
}

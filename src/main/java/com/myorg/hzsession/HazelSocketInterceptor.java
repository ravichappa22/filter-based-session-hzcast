package com.myorg.hzsession;

import com.hazelcast.nio.MemberSocketInterceptor;

import java.io.IOException;
import java.net.Socket;
import java.util.Properties;

public class HazelSocketInterceptor implements MemberSocketInterceptor {

    private String memberId;

    public HazelSocketInterceptor() {
    }

    @Override
    public void onAccept(Socket socket) throws IOException {
        socket.getOutputStream().write(memberId.getBytes());
        byte[] bytes = new byte[1024];
        int len = socket.getInputStream().read(bytes);
        String otherMemberId = new String(bytes, 0, len);
        if (!otherMemberId.equals(memberId)) {
            throw new RuntimeException("Not a known member!!!");
        }
    }

    @Override
    public void init(Properties properties) {
        System.out.println("member-id" + properties.getProperty("member-id"));
        memberId = properties.getProperty("member-id");
    }

    @Override
    public void onConnect(Socket socket) throws IOException {
        socket.getOutputStream().write(memberId.getBytes());
        byte[] bytes = new byte[1024];
        int len = socket.getInputStream().read(bytes);
        String otherMemberId = new String(bytes, 0, len);
        if (!otherMemberId.equals(memberId)) {
            throw new RuntimeException("Not a known member!!!");
        }
    }
}
package com.ssm;

import java.io.*;

/**
 * @author: create by bin
 * @version: v1.0
 * @description: com.ssm
 * @date:2019/8/21
 **/
public class Test {
    public static void main(String[] args) {
        DataInputStream dis = null;
        DataOutputStream dos = null;
        try {
            File inFile = new File("C:\\Users\\Bin\\AppData\\Local\\Netease\\CloudMusic\\Cache\\Cache\\1386079926-128-dcb8ac8d54cc0b5b189e230bde1a8874.uc");
            File outFile = new File("C:\\Users\\Bin\\Desktop\\杨和苏KeyNG - Wait for you (Live).mp3");

            dis = new DataInputStream(new FileInputStream(inFile));
            dos = new DataOutputStream(new FileOutputStream(outFile));
            byte[] b = new byte[1024];
            int len;
            while ((len = dis.read(b)) != -1) {
                for (int i = 0; i < len; i++) {
                    b[i] ^= 0xa3;
                }
                dos.write(b, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

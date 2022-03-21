package com.godeltech.l5pt5;

import java.io.*;

public class NIO_2_PT {

    public static void main(String[] args) {
        byte[][] arrayOfBytes = new byte[10][];

        System.out.println("Writing texts into the bytes.");

        for (int index = 0; index < arrayOfBytes.length; index++) {
            String text = String.format("It's is a text #%d.", index + 1);

            ByteArrayOutputStream byteArrayOutputStream = null;
            BufferedWriter bufferedWriter = null;

            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream));

                bufferedWriter.write(text);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                arrayOfBytes[index] = byteArrayOutputStream.toByteArray();

                System.out.println(String.format("\"%s\" -> bytes.", text));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        System.out.println();
        System.out.println("Reading texts from the bytes.");

        for (byte[] bytes : arrayOfBytes) {
            ByteArrayInputStream byteArrayInputStream = null;
            BufferedReader bufferedReader = null;

            try {
                byteArrayInputStream = new ByteArrayInputStream(bytes);
                bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream));

                System.out.println(String.format("bytes -> \"%s\".", bufferedReader.readLine()));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


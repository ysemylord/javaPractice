package net_other.tcpDemo4;

import java.io.Closeable;

public class Util {
    public static void closeAll(Closeable...ios){
        for (Closeable closeable:ios) {
            if (ios != null) {
                ios.clone();
            }
        }
    }
}

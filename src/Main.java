import java.net.*;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws SocketException {
        findMacAddress();
    }
    public static String [] findMacAddress() throws SocketException {

        String format = "%02X";

        Set <String> macs  = new HashSet<String>();
        Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();

        while(nis.hasMoreElements()){
            NetworkInterface ni = nis.nextElement();
            byte [] mac = ni.getHardwareAddress();

            if(mac != null){
                final StringBuilder macAddress = new StringBuilder();
                for (int i=1; i < mac.length; i++) {
                    macAddress.append(String.format("%s"+format , (i == 0) ? "" : ":", mac[i]));
                }
                System.out.println(macAddress.toString());
                macs.add(macAddress.toString());
                }
            }

        return macs.toArray(new String[0]);
    }
}

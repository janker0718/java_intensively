package cc.janker.javaIntensively.effective.java.Chapter2.Item3.field;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Singleton with public final field - Page 17
public class Elvis implements Serializable {
    public static final Elvis INSTANCE = new Elvis();
    private static final long serialVersionUID = -7353147647247157465L;

    private Elvis() { }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) throws IOException {
        Elvis elvis = Elvis.INSTANCE;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os  = new ObjectOutputStream(bos);
        os.writeObject(elvis);
        os.flush();
        os.close();
        byte[] b = bos.toByteArray();
        System.out.print(b.toString());
        //elvis.leaveTheBuilding();
    }
}

package com.ssm.designpattern.Metedata;

import java.io.*;

public class CloneModel implements Cloneable{
    public CloneModel clone() throws CloneNotSupportedException {
        return (CloneModel)super.clone();
    }

    public CloneModel deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(baos);
        oos.writeObject(this);
        ByteArrayInputStream bais=new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois=new   ObjectInputStream(bais);
        return (CloneModel)ois.readObject();
    }
}

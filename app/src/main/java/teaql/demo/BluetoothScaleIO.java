package teaql.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class BluetoothScaleIO {
    public  InputStream inputStream;
    public  OutputStream outStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public OutputStream getOutStream() {
        return outStream;
    }

    public void setOutStream(OutputStream outStream) {
        this.outStream = outStream;
    }

    public static BluetoothScaleIO instance(InputStream inputStream, OutputStream outputStream){

        BluetoothScaleIO bluetoothIO=new BluetoothScaleIO();
        bluetoothIO.setInputStream(inputStream);
        bluetoothIO.setOutStream(outputStream);
        return bluetoothIO;
    }

    protected static BluetoothScaleIO bluetoothScaleIO;


    public static BluetoothScaleIO init(InputStream inputStream, OutputStream outputStream){

        if(bluetoothScaleIO==null){
            bluetoothScaleIO=new BluetoothScaleIO();
        }
        bluetoothScaleIO.setInputStream(inputStream);
        bluetoothScaleIO.setOutStream(outputStream);
        return bluetoothScaleIO;
    }


    public static String readScale() throws IOException {

        if(bluetoothScaleIO==null){
            return  null;
        }

        String result=bluetoothScaleIO.getScaleResult();
        return result;
    }

    private String getScaleResult() throws IOException {

        sendRequest();
        return readResult();


    }

    protected void sendRequest() throws IOException {
        byte[] bytes = new byte[]{0x05,0x30,0x31,0x52,0x57,0x0d,0x0a};           //converts entered String into bytes
        outStream.write(bytes);

    }
    public String scaleString(byte[] bytes, int length) {
        try {
            // 使用 UTF-8 编码从第二个字节开始创建字符串
            return new String(bytes, 1, length - 1, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "fail";
        }


    }
    protected String readResult() throws IOException {
        byte[] buffer = new byte[1024];
        int length = inputStream.available();
        // how many bytes are ready to be read?
        int readLength = inputStream.read(buffer, 0, length);
        // record how many bytes we actually read
        return scaleString(buffer,readLength);


    }






}

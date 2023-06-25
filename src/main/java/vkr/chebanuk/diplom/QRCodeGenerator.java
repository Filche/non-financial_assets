package vkr.chebanuk.diplom;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import vkr.chebanuk.diplom.entity.Assets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {

    public static byte[] generateQRCode(Assets assets) throws WriterException, IOException {
//        String qrCodePath = "./src/main/resources/qrcodes/";
        String qrCodePath = "E:\\Programming\\Java\\Spring\\diplom\\src\\main\\webapp\\WEB-INF\\views\\images\\qrcode\\";
        String qrCodeName = qrCodePath+assets.getName()+"_"+assets.getInventoryNumber()+"_QRCODE.png";
        var qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(assets.getName() + ", " + assets.getInventoryNumber(), BarcodeFormat.QR_CODE, 300, 300);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", byteArrayOutputStream);
        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix,"PNG", path);
        return byteArrayOutputStream.toByteArray();
    }
}
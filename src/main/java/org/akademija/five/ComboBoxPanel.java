package org.akademija.five;

import net.coobird.thumbnailator.Thumbnails;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Domaća zadaća:
 * <p>
 * Iskoristi onaj ComboBox koji prikazuje u padajućem meniju sličice.
 * <p>
 * Učitati sličice s predavanje ali prije nego ih ComboBox prikaže smanjiti veličinu sličica.
 * Pri tome koristi se linkom: https://www.baeldung.com/java-resize-image
 * </p>
 */
public class ComboBoxPanel extends JPanel {
    //orginalnu sliku učitati kao BufferedImage
    BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

    BufferedImage resizeImage2(BufferedImage originalImage, int targetWidth, int targetHeight) {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }

    BufferedImage simpleResizeImage(BufferedImage originalImage, int targetWidth) throws Exception {
        return Scalr.resize(originalImage, targetWidth);
    }

    BufferedImage resizeImage3(BufferedImage originalImage, int targetWidth, int targetHeight) {
        try { //TRY_WITH_RESOURCES
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Thumbnails.of(originalImage)
                    .size(targetWidth, targetHeight)
                    .outputFormat("JPEG")
                    .outputQuality(1)
                    .toOutputStream(outputStream);
            byte[] data = outputStream.toByteArray();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
            return ImageIO.read(inputStream);
        } catch (Exception e) {
            //"gluho bilo obrada izuzetka"
            return null;
        }
    }
}

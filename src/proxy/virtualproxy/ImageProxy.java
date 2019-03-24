package proxy.virtualproxy;

import javafx.scene.image.Image;

import java.io.File;

class ImageProxy
{
    private static boolean retrieving = false;

    static void paintIcon(String imageURL)
    {
        String imageDir = "res/images/proxy/";
        Main.imageView.setImage(new Image(new File(imageDir + "loading.gif").toURI().toString()));

        if (!retrieving)
        {
            retrieving = true;
            Thread retrievalThread = new Thread(() -> {
                try
                {
                    Main.imageView.setImage(new Image(imageURL));
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            });
            retrievalThread.start();
            retrieving = false;
        }
    }
}
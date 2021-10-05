package com.app.Stickkers.Utils;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class Functions {

    public static void showStickerFresco(String link, SimpleDraweeView simpleDraweeView){
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(link)
                .setAutoPlayAnimations(true)
                .build();
        simpleDraweeView.setController(controller);
    }

}

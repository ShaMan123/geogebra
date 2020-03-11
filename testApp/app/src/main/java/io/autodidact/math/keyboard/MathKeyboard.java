package io.autodidact.math.keyboard;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.geogebra.keyboard.base.Button;
import org.geogebra.keyboard.base.model.KeyboardModel;

import java.util.ArrayList;
import java.util.List;

import io.autodidact.math.geogebra.R;

public class MathKeyboard extends Keyboard {

    private org.geogebra.keyboard.base.Keyboard mKeyboard;
    private List<Key> mKeys = new ArrayList<>(1);

    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MathKeyboard(Context context, org.geogebra.keyboard.base.Keyboard keyboard) {
        super(context, R.xml.kbd_popup_template);
        mKeyboard = keyboard;
        //setKeyHeight(50);
        //setKeyWidth(50);
        //setVerticalGap(10);
        //setHorizontalGap(10);
        int x, y;
        int rowSize = keyboard.getModel().getRows().size();
        int availableHeight = getHeight() / rowSize;
        for (int i = 0; i < rowSize; i++) {
            x = 0;
            y = availableHeight * i + getVerticalGap();
            Row row = new Keyboard.Row(this);

            for (Button button: keyboard.getModel().getRows().get(i).getButtons()) {
                Key key = new Key(row);
                //context.getAssets().openXmlResourceParser(button.getResourceName())
                //context.getResources().getValue();
                int drawableResourceId = context.getResources().getIdentifier(button.getResourceName(), "drawable", context.getPackageName());
                //key.icon = key.iconPreview = context.getResources().getDrawable(drawableResourceId, context.getTheme());
                key.label = key.text = button.getPrimaryActionName();
                key.gap = getHorizontalGap();
                key.width = getKeyWidth();
                key.height = getKeyHeight();
                x += key.gap;
                key.x = x;
                x += key.width;
                key.y = y;
                key.codes = new int[]{button.getPrimaryActionType().ordinal(), Keyboard.KEYCODE_MODE_CHANGE };

                key.popupCharacters = "abcdefg";
                mKeys.add(key);
                Log.d("Math", "MathKeyboard: " + key.text + " " +  button.getResourceName());
            }
        }


    }

    public MathKeyboard(Context context, int xmlLayoutResId) {
        super(context, xmlLayoutResId);
    }

    public MathKeyboard(Context context, int layoutTemplateResId,
                        CharSequence characters, int columns, int horizontalPadding) {
        super(context, layoutTemplateResId, characters, columns, horizontalPadding);
    }

    @Override
    public List<Key> getKeys() {
        return mKeys;
    }

    @Override
    public int[] getNearestKeys(int x, int y)
    {
        for (int i=0; i<mKeys.size(); i++) {
            Key k = mKeys.get(i);
            if (k.isInside(x,y)) return new int[]{i};
        }
        return new int[0];
    }

    @Override
    public int getHeight() { return 500; }
    @Override
    public int getMinWidth() { return 720; }


}

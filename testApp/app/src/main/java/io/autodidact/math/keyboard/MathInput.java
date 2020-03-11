package io.autodidact.math.keyboard;

import android.content.Context;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;

import com.himamis.retex.editor.android.FormulaEditor;

import org.geogebra.keyboard.base.KeyboardFactory;

public class MathInput extends KeyboardView {

    private FormulaEditor mFormulaEditor;

    public MathInput(Context context, AttributeSet attrs) {
        super(context, attrs);
        mFormulaEditor = new FormulaEditor(context, attrs);
        attachKeyboard();
    }

    public MathInput(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mFormulaEditor = new FormulaEditor(context, attrs, defStyleAttr);
        attachKeyboard();
    }

    void attachKeyboard() {
        KeyboardFactory keyboardFactory = new KeyboardFactory();
        setKeyboard(new MathKeyboard(getContext(), keyboardFactory.createMathKeyboard()));
    }

    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        attachKeyboard();
        return super.onCreateInputConnection(outAttrs);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        showKeyboard();
    }

    public boolean showKeyboard() {
        InputMethodManager imm = (InputMethodManager) getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.showSoftInput(this, InputMethodManager.SHOW_FORCED);
        }
        return true;
    }

}

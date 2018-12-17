package com.javarush.task.task32.task3209.actions;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

public class SuperscriptAction extends StyledEditorKit.StyledTextAction {

    public SuperscriptAction() {
        super(StyleConstants.Superscript.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JEditorPane editor = getEditor(e);
        if (editor != null) {
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes(); // получаем текущий атрибут (подч или нет)
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet(); // создаем новый атрибут
            StyleConstants.setSuperscript(simpleAttributeSet, !StyleConstants.isSuperscript(mutableAttributeSet));//устанавливаем новому атрибуту значение подчеркивания тру или фолс, смотря на то есть ли оно
            setCharacterAttributes(editor, simpleAttributeSet, false); //устанавливаем эдитору новый атрибут
        }

    }
}

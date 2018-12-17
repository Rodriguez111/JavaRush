package com.javarush.task.task32.task3209;


import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;

public class View extends JFrame implements ActionListener {

    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private FrameListener frameListener;

    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);


    public Controller getController() {
        return controller;
    }


    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        } catch (InstantiationException e) {
            ExceptionHandler.log(e);
        } catch (IllegalAccessException e) {
            ExceptionHandler.log(e);
        } catch (UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        }
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void init(){
        initGui();
        frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);

    }

    public void initMenuBar(){
        JMenuBar menuBar = new JMenuBar() ;
        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);
        getContentPane().add(menuBar, NORTH);
    }





    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.add("HTML", jScrollPane);
        JScrollPane jScrollPane2 = new JScrollPane(plainTextPane);
        tabbedPane.add("Текст", jScrollPane2);
        tabbedPane.setPreferredSize(new Dimension(800, 600));
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);
        getContentPane().add(tabbedPane, CENTER); //getContentPane() возвращает контейнер верхнего уровня


    }



    public void  initGui(){
        initMenuBar();
        initEditor();
        pack();

    }

    public void selectedTabChanged(){

        if(tabbedPane.getSelectedIndex() == 0){

            controller.setPlainText(plainTextPane.getText());

        }
        else if(tabbedPane.getSelectedIndex() == 1){

           plainTextPane.setText(controller.getPlainText());

        }

        resetUndo();

    }

    public void exit(){
        controller.exit();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command){
            case ("Новый"):{
                controller.createNewDocument();
                break;
            }
            case ("Открыть"):{
                controller.openDocument();
                break;
            }
            case ("Сохранить"):{
                controller.saveDocument();
                break;
            }
            case ("Сохранить как..."):{
                controller.saveDocumentAs();
                break;
            }
            case ("Выход"):{
                controller.exit();
                break;
            }
            case ("О программе"):{
                showAbout();
                break;
            }
        }


    }

    public boolean canUndo(){
        if(undoManager.canUndo()){return true;}

        return false;

    }

    public boolean canRedo(){
        if(undoManager.canRedo()){return true;}
        return false;
    }

    public boolean isHtmlTabSelected(){
       if(tabbedPane.getSelectedIndex() == 0) {
           return true;
       }
        return false;
    }

    public void undo(){
        try {
            undoManager.undo();
        }catch (CannotUndoException e){
            ExceptionHandler.log(e);
        }
    }

    public void redo(){
        try {
            undoManager.redo();
        }catch (CannotRedoException e){
            ExceptionHandler.log(e);
        }
    }

    public void resetUndo(){
        undoManager.discardAllEdits();
    }

   public void selectHtmlTab(){
       tabbedPane.setSelectedIndex(0);
       resetUndo();
   }

   public void update(){
       htmlTextPane.setDocument(controller.getDocument());
   }

   public void showAbout(){
       JOptionPane.showMessageDialog(this,
               "Здесь содержится информация о программе",
               "О программе",
               JOptionPane.INFORMATION_MESSAGE);
   }



}

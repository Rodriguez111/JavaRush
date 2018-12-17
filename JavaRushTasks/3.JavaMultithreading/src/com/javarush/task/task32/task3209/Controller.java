package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public void init(){
        createNewDocument();
    }

    public void exit(){
        System.exit(0);
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void resetDocument(){
        if(document != null){
            document.removeUndoableEditListener(view.getUndoListener()); //Удаляем у текущего документа document слушателя правок которые можно отменить/вернуть
        }
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        document = (HTMLDocument)htmlEditorKit.createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text){
        resetDocument();
        StringReader reader = new StringReader(text);
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.read(reader, document, 0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }

    }

    public String getPlainText(){
        StringWriter writer = new StringWriter();
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
         htmlEditorKit.write(writer, document, 0, document.getLength());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }

    public void createNewDocument(){
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }
    public void openDocument(){

        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        int result = jFileChooser.showOpenDialog(view);
        if(result == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try(FileReader fr = new FileReader(currentFile)){
                HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                htmlEditorKit.read(fr, document, 0);

            }catch (IOException e) {
                ExceptionHandler.log(e);
            }catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }
            view.resetUndo();
        }
    }


    public void saveDocument(){
        view.selectHtmlTab();
       if(currentFile == null){
           saveDocumentAs();
       }
       else {

           try(FileWriter fw = new FileWriter(currentFile))
           {

               HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
               htmlEditorKit.write(fw, document, 0, document.getLength());

           } catch (IOException e) {
               ExceptionHandler.log(e);
           }catch (BadLocationException e) {
               ExceptionHandler.log(e);
           }

       }

    }


    public void saveDocumentAs(){
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
       int result = jFileChooser.showSaveDialog(view);
       if(result == JFileChooser.APPROVE_OPTION){
        currentFile = jFileChooser.getSelectedFile();
        view.setTitle(currentFile.getName());

           try(FileWriter fr = new FileWriter(currentFile))
            {

                HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                htmlEditorKit.write(fr, document, 0, document.getLength());

            } catch (IOException e) {
                ExceptionHandler.log(e);
            }catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }




       }
    }

}

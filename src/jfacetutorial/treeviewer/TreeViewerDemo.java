package jfacetutorial.treeviewer;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Tree;

import jfacetutorial.DataModel;

public class TreeViewerDemo {

  protected Shell shlTreeviewerDemo;

  /**
   * Launch the application.
   * @param args
   */
  public static void main(String[] args) {
      try {
          TreeViewerDemo window = new TreeViewerDemo();
          window.open();
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

  /**
   * Open the window.
   */
  public void open() {
      Display display = Display.getDefault();
      createContents();
      shlTreeviewerDemo.open();
      shlTreeviewerDemo.layout();
      while (!shlTreeviewerDemo.isDisposed()) {
          if (!display.readAndDispatch()) {
              display.sleep();
          }
      }
  }

  /**
   * Create contents of the window.
   */
  protected void createContents() {
      shlTreeviewerDemo = new Shell();
      shlTreeviewerDemo.setSize(475, 394);
      shlTreeviewerDemo.setText("TreeViewer Demo");
      shlTreeviewerDemo.setLayout(new FillLayout(SWT.HORIZONTAL));
     
      TreeViewer treeViewer = new TreeViewer(shlTreeviewerDemo, SWT.BORDER);
     
      AppMenuTreeCLProvider provider= new AppMenuTreeCLProvider();
      treeViewer.setContentProvider(provider);
      treeViewer.setLabelProvider(provider);
     
      Tree tree = treeViewer.getTree();
      tree.setLinesVisible(true);
      tree.setHeaderVisible(true);
     
      treeViewer.setInput(DataModel.getAppMenus());
      
  }
}
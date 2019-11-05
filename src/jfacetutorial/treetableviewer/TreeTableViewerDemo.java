package jfacetutorial.treetableviewer;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.TreeColumn;

import java.util.List;
import jfacetutorial.DataModel;
import jfacetutorial.Department;
import jfacetutorial.Employee;

public class TreeTableViewerDemo {

  protected Shell shlTreeTableViewer;

  /**
   * Launch the application.
   * @param args
   */
  public static void main(String[] args) {
      try {
          TreeTableViewerDemo window = new TreeTableViewerDemo();
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
      shlTreeTableViewer.open();
      shlTreeTableViewer.layout();
      while (!shlTreeTableViewer.isDisposed()) {
          if (!display.readAndDispatch()) {
              display.sleep();
          }
      }
  }

  /**
   * Create contents of the window.
   */
  protected void createContents() {
      shlTreeTableViewer = new Shell();
      shlTreeTableViewer.setSize(438, 226);
      shlTreeTableViewer.setText("Tree Table Viewer");
      shlTreeTableViewer.setLayout(new FillLayout(SWT.HORIZONTAL));
     
      TreeViewer treeViewer = new TreeViewer(shlTreeTableViewer, SWT.BORDER);
     
      DeptEmpTreeTableCLProvider provider= new DeptEmpTreeTableCLProvider();
      treeViewer.setContentProvider(provider);
      treeViewer.setLabelProvider(provider);
             
      Tree tree = treeViewer.getTree();
      tree.setLinesVisible(true);
      tree.setHeaderVisible(true);
     
      TreeColumn trclmnDeptNo = new TreeColumn(tree, SWT.NONE);
      trclmnDeptNo.setWidth(71);
      trclmnDeptNo.setText("Dept No");
     
      TreeColumn trclmnDeptName = new TreeColumn(tree, SWT.NONE);
      trclmnDeptName.setWidth(79);
      trclmnDeptName.setText("Dept Name");
     
      TreeColumn trclmnEmpNo = new TreeColumn(tree, SWT.NONE);
      trclmnEmpNo.setWidth(69);
      trclmnEmpNo.setText("Emp No");
     
      TreeColumn trclmnFirstName = new TreeColumn(tree, SWT.NONE);
      trclmnFirstName.setWidth(77);
      trclmnFirstName.setText("First Name");
     
      TreeColumn trclmnLastName = new TreeColumn(tree, SWT.NONE);
      trclmnLastName.setWidth(100);
      trclmnLastName.setText("Last Name");
     
      treeViewer.setInput(DataModel.getDepartments());
  }

}
package midterm18_wu;

import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final String PERSPECTIVE_ID = "midterm18_WU.perspective"; //$NON-NLS-1$

	@Override
    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }
    
    @Override
	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}
}

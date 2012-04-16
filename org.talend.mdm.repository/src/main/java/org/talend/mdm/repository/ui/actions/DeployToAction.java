// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.ui.actions;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.mdm.repository.core.command.ICommand;
import org.talend.mdm.repository.i18n.Messages;
import org.talend.mdm.repository.model.mdmmetadata.MDMServerDef;
import org.talend.mdm.repository.ui.dialogs.lock.LockedObjectDialog;
import org.talend.mdm.repository.ui.editors.IRepositoryViewEditorInput;
import org.talend.mdm.workbench.serverexplorer.ui.dialogs.SelectServerDefDialog;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class DeployToAction extends AbstractDeployAction {

    public DeployToAction() {
        super(Messages.DeployToAction_deployTo);

    }

    protected void doRun() {

        doSaveEditorsThing();
        
        List<IRepositoryViewObject> viewObjs = getSelectedRepositoryViewObject();
        
        LockedObjectDialog lockDialog = new LockedObjectDialog(getShell(), Messages.DeployAction_lockedObjectMessage,
                Messages.DeployAction_singleLockedObjectMessage, viewObjs);
        if (lockDialog.needShowDialog() && lockDialog.open() == IDialogConstants.CANCEL_ID) {
            return;
        }
        if (!lockDialog.canContinueRestOperation())
            return;
        SelectServerDefDialog dialog = new SelectServerDefDialog(getShell());
        if (dialog.open() == IDialogConstants.OK_ID) {
            MDMServerDef serverDef = dialog.getSelectedServerDef();

            IStatus status = deploy(serverDef, viewObjs, ICommand.CMD_MODIFY);
            updateChangedStatus(status);
            if (status.isMultiStatus()) {
                showDeployStatus(status);
            }

            updateLastServer(new NullProgressMonitor());
        }

    }

//    private void doSaveEditorsThing() {
//        List<IRepositoryViewObject> viewObjs = getSelectedRepositoryViewObject();
//        
//        boolean isEditing = false;
//        
//        IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
//        try {
//            for (IEditorReference editorReference : activePage.getEditorReferences()) {
//                IRepositoryViewObject viewObject = ((IRepositoryViewEditorInput) editorReference.getEditorInput()).getViewObject();
//                if (viewObjs.contains(viewObject))
//                {
//                    isEditing = true;
//                    break;
//                }
//            }
//            
//            if (isEditing) {
//                activePage.saveAllEditors(true);
//            }
//        } catch (PartInitException e1) {
//            e1.printStackTrace();
//        }
//    }

}

// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.core.service.interactive;

import java.rmi.RemoteException;

import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.mdm.repository.core.IServerObjectRepositoryType;
import org.talend.mdm.repository.i18n.Messages;

import com.amalto.workbench.models.TreeObject;
import com.amalto.workbench.webservices.WSDeleteUniverse;
import com.amalto.workbench.webservices.WSPutUniverse;
import com.amalto.workbench.webservices.WSUniverse;
import com.amalto.workbench.webservices.WSUniversePK;
import com.amalto.workbench.webservices.XtentisPort;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class VersionInteractiveHandler extends AbstractInteractiveHandler {

    public ERepositoryObjectType getRepositoryObjectType() {
        return IServerObjectRepositoryType.TYPE_UNIVERSE;
    }

    public String getLabel() {

        return Messages.VersionInteractiveHandler_label;
    }

    public boolean doDeploy(XtentisPort port, Object wsObj) throws RemoteException {
        if (wsObj != null) {
            port.putUniverse(new WSPutUniverse((WSUniverse) wsObj));
            return true;
        }
        return false;
    }

    public boolean doDelete(XtentisPort port, TreeObject xobject) throws RemoteException {

        if (xobject != null) {
            if (xobject.getWsKey() instanceof String) {
                WSUniversePK pk = new WSUniversePK();
                pk.setPk((String) xobject.getWsKey());
                port.deleteUniverse(new WSDeleteUniverse(pk));
            } else
                port.deleteUniverse(new WSDeleteUniverse((WSUniversePK) xobject.getWsKey()));

            return true;
        }
        return false;
    }

}

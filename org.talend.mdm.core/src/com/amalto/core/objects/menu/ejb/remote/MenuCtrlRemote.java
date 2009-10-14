 /*
 * Generated by XDoclet - Do not edit!
 * this class was prodiuced by xdoclet automagically...
 */
package com.amalto.core.objects.menu.ejb.remote;

import java.util.*;

/**
 * This class is remote adapter to MenuCtrl. It provides convenient way to access
 * facade session bean. Inverit from this class to provide reasonable caching and event handling capabilities.
 *
 * Remote facade for MenuCtrl.
 * @xdoclet-generated at 14-10-09
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */

public class MenuCtrlRemote extends Observable
{
    static MenuCtrlRemote _instance = null;
    public static MenuCtrlRemote getInstance() {
        if(_instance == null) {
	   _instance = new MenuCtrlRemote();
	}
	return _instance;
    }

  /**
   * cached remote session interface
   */
  com.amalto.core.objects.menu.ejb.remote.MenuCtrl _session = null;
  /**
   * return session bean remote interface
   */
   protected com.amalto.core.objects.menu.ejb.remote.MenuCtrl getSession() {
      try {
   	if(_session == null) {
	   _session = com.amalto.core.objects.menu.ejb.local.MenuCtrlUtil.getHome().create();
	}
	return _session;
      } catch(Exception ex) {
        // just catch it here and return null.
        // somebody can provide better solution
	ex.printStackTrace();
	return null;
      }
   }

   public com.amalto.core.objects.menu.ejb.MenuPOJOPK putMenu ( com.amalto.core.objects.menu.ejb.MenuPOJO menu )
	  throws com.amalto.core.util.XtentisException, java.rmi.RemoteException
   {
        com.amalto.core.objects.menu.ejb.MenuPOJOPK retval;
       retval =  getSession().putMenu( menu );

      return retval;

   }

   public com.amalto.core.objects.menu.ejb.MenuPOJO getMenu ( com.amalto.core.objects.menu.ejb.MenuPOJOPK pk )
	  throws com.amalto.core.util.XtentisException, java.rmi.RemoteException
   {
        com.amalto.core.objects.menu.ejb.MenuPOJO retval;
       retval =  getSession().getMenu( pk );

      return retval;

   }

   public com.amalto.core.objects.menu.ejb.MenuPOJO existsMenu ( com.amalto.core.objects.menu.ejb.MenuPOJOPK pk )
	  throws com.amalto.core.util.XtentisException, java.rmi.RemoteException
   {
        com.amalto.core.objects.menu.ejb.MenuPOJO retval;
       retval =  getSession().existsMenu( pk );

      return retval;

   }

   public com.amalto.core.objects.menu.ejb.MenuPOJOPK removeMenu ( com.amalto.core.objects.menu.ejb.MenuPOJOPK pk )
	  throws com.amalto.core.util.XtentisException, java.rmi.RemoteException
   {
        com.amalto.core.objects.menu.ejb.MenuPOJOPK retval;
       retval =  getSession().removeMenu( pk );

      return retval;

   }

   public java.util.Collection getMenuPKs ( java.lang.String regex )
	  throws com.amalto.core.util.XtentisException, java.rmi.RemoteException
   {
        java.util.Collection retval;
       retval =  getSession().getMenuPKs( regex );

      return retval;

   }

  /**
   * override this method to provide feedback to interested objects
   * in case collections were changed.
   */
  public void invalidate() {

  	setChanged();
	notifyObservers();
  }
}

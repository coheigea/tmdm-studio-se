/*
 * Generated by XDoclet - Do not edit!
 */
package com.amalto.core.objects.menu.ejb.remote;

/**
 * Home interface for MenuCtrl.
 * @xdoclet-generated at 14-10-09
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version ${version}
 */
public interface MenuCtrlHome
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/MenuCtrl";
   public static final String JNDI_NAME="amalto/remote/core/menuctrl";

   public com.amalto.core.objects.menu.ejb.remote.MenuCtrl create()
      throws javax.ejb.CreateException,java.rmi.RemoteException;

}

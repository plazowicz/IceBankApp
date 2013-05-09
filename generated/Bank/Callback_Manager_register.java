// **********************************************************************
//
// Copyright (c) 2003-2011 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.4.2
//
// <auto-generated>
//
// Generated from file `Callback_Manager_register.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Bank;

public abstract class Callback_Manager_register extends Ice.TwowayCallback
{
    public abstract void response(boolean __ret);
    public abstract void exception(Ice.UserException __ex);

    public final void __completed(Ice.AsyncResult __result)
    {
        ManagerPrx __proxy = (ManagerPrx)__result.getProxy();
        boolean __ret = false;
        try
        {
            __ret = __proxy.end_register(__result);
        }
        catch(Ice.UserException __ex)
        {
            exception(__ex);
            return;
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret);
    }
}

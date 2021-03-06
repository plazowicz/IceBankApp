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
// Generated from file `Callback_Account_login.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Bank;

public abstract class Callback_Account_login extends Ice.TwowayCallback
{
    public abstract void response(String __ret);
    public abstract void exception(Ice.UserException __ex);

    public final void __completed(Ice.AsyncResult __result)
    {
        AccountPrx __proxy = (AccountPrx)__result.getProxy();
        String __ret = null;
        try
        {
            __ret = __proxy.end_login(__result);
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

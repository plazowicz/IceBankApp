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
// Generated from file `Callback_Room_getHistory.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Chat;

public abstract class Callback_Room_getHistory extends Ice.TwowayCallback
{
    public abstract void response(Message[] __ret);
    public abstract void exception(Ice.UserException __ex);

    public final void __completed(Ice.AsyncResult __result)
    {
        RoomPrx __proxy = (RoomPrx)__result.getProxy();
        Message[] __ret = null;
        try
        {
            __ret = __proxy.end_getHistory(__result);
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
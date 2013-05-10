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
// Generated from file `ClientCallbackPrxHelper.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Chat;

public final class ClientCallbackPrxHelper extends Ice.ObjectPrxHelperBase implements ClientCallbackPrx
{
    public void
    stateDidChange(Message change)
    {
        stateDidChange(change, null, false);
    }

    public void
    stateDidChange(Message change, java.util.Map<String, String> __ctx)
    {
        stateDidChange(change, __ctx, true);
    }

    private void
    stateDidChange(Message change, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __delBase = __getDelegate(false);
                _ClientCallbackDel __del = (_ClientCallbackDel)__delBase;
                __del.stateDidChange(change, __ctx);
                return;
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, null, __cnt);
            }
        }
    }

    private static final String __stateDidChange_name = "stateDidChange";

    public Ice.AsyncResult begin_stateDidChange(Message change)
    {
        return begin_stateDidChange(change, null, false, null);
    }

    public Ice.AsyncResult begin_stateDidChange(Message change, java.util.Map<String, String> __ctx)
    {
        return begin_stateDidChange(change, __ctx, true, null);
    }

    public Ice.AsyncResult begin_stateDidChange(Message change, Ice.Callback __cb)
    {
        return begin_stateDidChange(change, null, false, __cb);
    }

    public Ice.AsyncResult begin_stateDidChange(Message change, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_stateDidChange(change, __ctx, true, __cb);
    }

    public Ice.AsyncResult begin_stateDidChange(Message change, Callback_ClientCallback_stateDidChange __cb)
    {
        return begin_stateDidChange(change, null, false, __cb);
    }

    public Ice.AsyncResult begin_stateDidChange(Message change, java.util.Map<String, String> __ctx, Callback_ClientCallback_stateDidChange __cb)
    {
        return begin_stateDidChange(change, __ctx, true, __cb);
    }

    private Ice.AsyncResult begin_stateDidChange(Message change, java.util.Map<String, String> __ctx, boolean __explicitCtx, IceInternal.CallbackBase __cb)
    {
        IceInternal.OutgoingAsync __result = new IceInternal.OutgoingAsync(this, __stateDidChange_name, __cb);
        try
        {
            __result.__prepare(__stateDidChange_name, Ice.OperationMode.Normal, __ctx, __explicitCtx);
            IceInternal.BasicStream __os = __result.__os();
            __os.writeObject(change);
            __os.writePendingObjects();
            __os.endWriteEncaps();
            __result.__send(true);
        }
        catch(Ice.LocalException __ex)
        {
            __result.__exceptionAsync(__ex);
        }
        return __result;
    }

    public void end_stateDidChange(Ice.AsyncResult __result)
    {
        __end(__result, __stateDidChange_name);
    }

    public static ClientCallbackPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        ClientCallbackPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ClientCallbackPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId()))
                {
                    ClientCallbackPrxHelper __h = new ClientCallbackPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static ClientCallbackPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        ClientCallbackPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ClientCallbackPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId(), __ctx))
                {
                    ClientCallbackPrxHelper __h = new ClientCallbackPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static ClientCallbackPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        ClientCallbackPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId()))
                {
                    ClientCallbackPrxHelper __h = new ClientCallbackPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static ClientCallbackPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        ClientCallbackPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId(), __ctx))
                {
                    ClientCallbackPrxHelper __h = new ClientCallbackPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static ClientCallbackPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        ClientCallbackPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ClientCallbackPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                ClientCallbackPrxHelper __h = new ClientCallbackPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static ClientCallbackPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        ClientCallbackPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            ClientCallbackPrxHelper __h = new ClientCallbackPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    public static final String[] __ids =
    {
        "::Chat::ClientCallback",
        "::Ice::Object"
    };

    public static String
    ice_staticId()
    {
        return __ids[0];
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _ClientCallbackDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _ClientCallbackDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, ClientCallbackPrx v)
    {
        __os.writeProxy(v);
    }

    public static ClientCallbackPrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            ClientCallbackPrxHelper result = new ClientCallbackPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
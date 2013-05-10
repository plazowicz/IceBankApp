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
// Generated from file `MessagePrxHelper.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Chat;

public final class MessagePrxHelper extends Ice.ObjectPrxHelperBase implements MessagePrx
{
    public static MessagePrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        MessagePrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (MessagePrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId()))
                {
                    MessagePrxHelper __h = new MessagePrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static MessagePrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        MessagePrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (MessagePrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId(), __ctx))
                {
                    MessagePrxHelper __h = new MessagePrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static MessagePrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        MessagePrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId()))
                {
                    MessagePrxHelper __h = new MessagePrxHelper();
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

    public static MessagePrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        MessagePrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId(), __ctx))
                {
                    MessagePrxHelper __h = new MessagePrxHelper();
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

    public static MessagePrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        MessagePrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (MessagePrx)__obj;
            }
            catch(ClassCastException ex)
            {
                MessagePrxHelper __h = new MessagePrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static MessagePrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        MessagePrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            MessagePrxHelper __h = new MessagePrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    public static final String[] __ids =
    {
        "::Chat::Message",
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
        return new _MessageDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _MessageDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, MessagePrx v)
    {
        __os.writeProxy(v);
    }

    public static MessagePrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            MessagePrxHelper result = new MessagePrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}

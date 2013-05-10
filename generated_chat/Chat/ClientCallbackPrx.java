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
// Generated from file `ClientCallbackPrx.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Chat;

public interface ClientCallbackPrx extends Ice.ObjectPrx
{
    public void stateDidChange(Message change);

    public void stateDidChange(Message change, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_stateDidChange(Message change);

    public Ice.AsyncResult begin_stateDidChange(Message change, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_stateDidChange(Message change, Ice.Callback __cb);

    public Ice.AsyncResult begin_stateDidChange(Message change, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_stateDidChange(Message change, Callback_ClientCallback_stateDidChange __cb);

    public Ice.AsyncResult begin_stateDidChange(Message change, java.util.Map<String, String> __ctx, Callback_ClientCallback_stateDidChange __cb);

    public void end_stateDidChange(Ice.AsyncResult __result);
}

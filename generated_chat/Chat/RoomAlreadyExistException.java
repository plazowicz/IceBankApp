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
// Generated from file `RoomAlreadyExistException.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Chat;

public class RoomAlreadyExistException extends Ice.UserException
{
    public RoomAlreadyExistException()
    {
    }

    public RoomAlreadyExistException(Throwable cause)
    {
        super(cause);
    }

    public RoomAlreadyExistException(String description)
    {
        this.description = description;
    }

    public RoomAlreadyExistException(String description, Throwable cause)
    {
        super(cause);
        this.description = description;
    }

    public String
    ice_name()
    {
        return "Chat::RoomAlreadyExistException";
    }

    public String description;

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeString("::Chat::RoomAlreadyExistException");
        __os.startWriteSlice();
        __os.writeString(description);
        __os.endWriteSlice();
    }

    public void
    __read(IceInternal.BasicStream __is, boolean __rid)
    {
        if(__rid)
        {
            __is.readString();
        }
        __is.startReadSlice();
        description = __is.readString();
        __is.endReadSlice();
    }

    public void
    __write(Ice.OutputStream __outS)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "exception Chat::RoomAlreadyExistException was not generated with stream support";
        throw ex;
    }

    public void
    __read(Ice.InputStream __inS, boolean __rid)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "exception Chat::RoomAlreadyExistException was not generated with stream support";
        throw ex;
    }
}

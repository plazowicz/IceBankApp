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
// Generated from file `RoomsHelper.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Chat;

public final class RoomsHelper
{
    public static void
    write(IceInternal.BasicStream __os, String[] __v)
    {
        __os.writeStringSeq(__v);
    }

    public static String[]
    read(IceInternal.BasicStream __is)
    {
        String[] __v;
        __v = __is.readStringSeq();
        return __v;
    }
}

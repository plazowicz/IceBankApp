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
// Generated from file `_AccountOperationsNC.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Bank;

public interface _AccountOperationsNC
{
    String login(String PESEL, String password)
        throws IncorrectPasswordException,
               UserAlreadyLoggedInException,
               UserNotExistException;

    boolean logout()
        throws UserAlreadyLoggedOutException;

    int getState()
        throws UserNotLoggedIn;

    int withdraw(int stake)
        throws InsufficientFundsException,
               UserNotLoggedIn;

    boolean deposit(int stake)
        throws UserNotLoggedIn;
}

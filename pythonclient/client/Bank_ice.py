# **********************************************************************
#
# Copyright (c) 2003-2011 ZeroC, Inc. All rights reserved.
#
# This copy of Ice is licensed to you under the terms described in the
# ICE_LICENSE file included in this distribution.
#
# **********************************************************************
#
# Ice version 3.4.2
#
# <auto-generated>
#
# Generated from file `Bank.ice'
#
# Warning: do not edit this file.
#
# </auto-generated>
#

import Ice, IcePy, __builtin__

# Start of module Bank
_M_Bank = Ice.openModule('Bank')
__name__ = 'Bank'

if not _M_Bank.__dict__.has_key('UserAlreadyLoggedInException'):
    _M_Bank.UserAlreadyLoggedInException = Ice.createTempClass()
    class UserAlreadyLoggedInException(Ice.UserException):
        def __init__(self, description=''):
            self.description = description

        def __str__(self):
            return IcePy.stringifyException(self)

        __repr__ = __str__

        _ice_name = 'Bank::UserAlreadyLoggedInException'

    _M_Bank._t_UserAlreadyLoggedInException = IcePy.defineException('::Bank::UserAlreadyLoggedInException', UserAlreadyLoggedInException, (), None, (('description', (), IcePy._t_string),))
    UserAlreadyLoggedInException._ice_type = _M_Bank._t_UserAlreadyLoggedInException

    _M_Bank.UserAlreadyLoggedInException = UserAlreadyLoggedInException
    del UserAlreadyLoggedInException

if not _M_Bank.__dict__.has_key('UserNotExistException'):
    _M_Bank.UserNotExistException = Ice.createTempClass()
    class UserNotExistException(Ice.UserException):
        def __init__(self, description=''):
            self.description = description

        def __str__(self):
            return IcePy.stringifyException(self)

        __repr__ = __str__

        _ice_name = 'Bank::UserNotExistException'

    _M_Bank._t_UserNotExistException = IcePy.defineException('::Bank::UserNotExistException', UserNotExistException, (), None, (('description', (), IcePy._t_string),))
    UserNotExistException._ice_type = _M_Bank._t_UserNotExistException

    _M_Bank.UserNotExistException = UserNotExistException
    del UserNotExistException

if not _M_Bank.__dict__.has_key('IncorrectPasswordException'):
    _M_Bank.IncorrectPasswordException = Ice.createTempClass()
    class IncorrectPasswordException(Ice.UserException):
        def __init__(self, description=''):
            self.description = description

        def __str__(self):
            return IcePy.stringifyException(self)

        __repr__ = __str__

        _ice_name = 'Bank::IncorrectPasswordException'

    _M_Bank._t_IncorrectPasswordException = IcePy.defineException('::Bank::IncorrectPasswordException', IncorrectPasswordException, (), None, (('description', (), IcePy._t_string),))
    IncorrectPasswordException._ice_type = _M_Bank._t_IncorrectPasswordException

    _M_Bank.IncorrectPasswordException = IncorrectPasswordException
    del IncorrectPasswordException

if not _M_Bank.__dict__.has_key('UserAlreadyLoggedOutException'):
    _M_Bank.UserAlreadyLoggedOutException = Ice.createTempClass()
    class UserAlreadyLoggedOutException(Ice.UserException):
        def __init__(self, description=''):
            self.description = description

        def __str__(self):
            return IcePy.stringifyException(self)

        __repr__ = __str__

        _ice_name = 'Bank::UserAlreadyLoggedOutException'

    _M_Bank._t_UserAlreadyLoggedOutException = IcePy.defineException('::Bank::UserAlreadyLoggedOutException', UserAlreadyLoggedOutException, (), None, (('description', (), IcePy._t_string),))
    UserAlreadyLoggedOutException._ice_type = _M_Bank._t_UserAlreadyLoggedOutException

    _M_Bank.UserAlreadyLoggedOutException = UserAlreadyLoggedOutException
    del UserAlreadyLoggedOutException

if not _M_Bank.__dict__.has_key('InsufficientFundsException'):
    _M_Bank.InsufficientFundsException = Ice.createTempClass()
    class InsufficientFundsException(Ice.UserException):
        def __init__(self, description=''):
            self.description = description

        def __str__(self):
            return IcePy.stringifyException(self)

        __repr__ = __str__

        _ice_name = 'Bank::InsufficientFundsException'

    _M_Bank._t_InsufficientFundsException = IcePy.defineException('::Bank::InsufficientFundsException', InsufficientFundsException, (), None, (('description', (), IcePy._t_string),))
    InsufficientFundsException._ice_type = _M_Bank._t_InsufficientFundsException

    _M_Bank.InsufficientFundsException = InsufficientFundsException
    del InsufficientFundsException

if not _M_Bank.__dict__.has_key('UserAlreadyExistException'):
    _M_Bank.UserAlreadyExistException = Ice.createTempClass()
    class UserAlreadyExistException(Ice.UserException):
        def __init__(self, description=''):
            self.description = description

        def __str__(self):
            return IcePy.stringifyException(self)

        __repr__ = __str__

        _ice_name = 'Bank::UserAlreadyExistException'

    _M_Bank._t_UserAlreadyExistException = IcePy.defineException('::Bank::UserAlreadyExistException', UserAlreadyExistException, (), None, (('description', (), IcePy._t_string),))
    UserAlreadyExistException._ice_type = _M_Bank._t_UserAlreadyExistException

    _M_Bank.UserAlreadyExistException = UserAlreadyExistException
    del UserAlreadyExistException

if not _M_Bank.__dict__.has_key('UserNotLoggedIn'):
    _M_Bank.UserNotLoggedIn = Ice.createTempClass()
    class UserNotLoggedIn(Ice.UserException):
        def __init__(self, description=''):
            self.description = description

        def __str__(self):
            return IcePy.stringifyException(self)

        __repr__ = __str__

        _ice_name = 'Bank::UserNotLoggedIn'

    _M_Bank._t_UserNotLoggedIn = IcePy.defineException('::Bank::UserNotLoggedIn', UserNotLoggedIn, (), None, (('description', (), IcePy._t_string),))
    UserNotLoggedIn._ice_type = _M_Bank._t_UserNotLoggedIn

    _M_Bank.UserNotLoggedIn = UserNotLoggedIn
    del UserNotLoggedIn

if not _M_Bank.__dict__.has_key('Account'):
    _M_Bank.Account = Ice.createTempClass()
    class Account(Ice.Object):
        def __init__(self):
            if __builtin__.type(self) == _M_Bank.Account:
                raise RuntimeError('Bank.Account is an abstract class')

        def ice_ids(self, current=None):
            return ('::Bank::Account', '::Ice::Object')

        def ice_id(self, current=None):
            return '::Bank::Account'

        def ice_staticId():
            return '::Bank::Account'
        ice_staticId = staticmethod(ice_staticId)

        def login(self, PESEL, password, current=None):
            pass

        def logout(self, current=None):
            pass

        def getState(self, current=None):
            pass

        def withdraw(self, stake, current=None):
            pass

        def deposit(self, stake, current=None):
            pass

        def __str__(self):
            return IcePy.stringify(self, _M_Bank._t_Account)

        __repr__ = __str__

    _M_Bank.AccountPrx = Ice.createTempClass()
    class AccountPrx(Ice.ObjectPrx):

        def login(self, PESEL, password, _ctx=None):
            return _M_Bank.Account._op_login.invoke(self, ((PESEL, password), _ctx))

        def begin_login(self, PESEL, password, _response=None, _ex=None, _sent=None, _ctx=None):
            return _M_Bank.Account._op_login.begin(self, ((PESEL, password), _response, _ex, _sent, _ctx))

        def end_login(self, _r):
            return _M_Bank.Account._op_login.end(self, _r)

        def logout(self, _ctx=None):
            return _M_Bank.Account._op_logout.invoke(self, ((), _ctx))

        def begin_logout(self, _response=None, _ex=None, _sent=None, _ctx=None):
            return _M_Bank.Account._op_logout.begin(self, ((), _response, _ex, _sent, _ctx))

        def end_logout(self, _r):
            return _M_Bank.Account._op_logout.end(self, _r)

        def getState(self, _ctx=None):
            return _M_Bank.Account._op_getState.invoke(self, ((), _ctx))

        def begin_getState(self, _response=None, _ex=None, _sent=None, _ctx=None):
            return _M_Bank.Account._op_getState.begin(self, ((), _response, _ex, _sent, _ctx))

        def end_getState(self, _r):
            return _M_Bank.Account._op_getState.end(self, _r)

        def withdraw(self, stake, _ctx=None):
            return _M_Bank.Account._op_withdraw.invoke(self, ((stake, ), _ctx))

        def begin_withdraw(self, stake, _response=None, _ex=None, _sent=None, _ctx=None):
            return _M_Bank.Account._op_withdraw.begin(self, ((stake, ), _response, _ex, _sent, _ctx))

        def end_withdraw(self, _r):
            return _M_Bank.Account._op_withdraw.end(self, _r)

        def deposit(self, stake, _ctx=None):
            return _M_Bank.Account._op_deposit.invoke(self, ((stake, ), _ctx))

        def begin_deposit(self, stake, _response=None, _ex=None, _sent=None, _ctx=None):
            return _M_Bank.Account._op_deposit.begin(self, ((stake, ), _response, _ex, _sent, _ctx))

        def end_deposit(self, _r):
            return _M_Bank.Account._op_deposit.end(self, _r)

        def checkedCast(proxy, facetOrCtx=None, _ctx=None):
            return _M_Bank.AccountPrx.ice_checkedCast(proxy, '::Bank::Account', facetOrCtx, _ctx)
        checkedCast = staticmethod(checkedCast)

        def uncheckedCast(proxy, facet=None):
            return _M_Bank.AccountPrx.ice_uncheckedCast(proxy, facet)
        uncheckedCast = staticmethod(uncheckedCast)

    _M_Bank._t_AccountPrx = IcePy.defineProxy('::Bank::Account', AccountPrx)

    _M_Bank._t_Account = IcePy.defineClass('::Bank::Account', Account, (), True, None, (), ())
    Account._ice_type = _M_Bank._t_Account

    Account._op_login = IcePy.Operation('login', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, (), (((), IcePy._t_string), ((), IcePy._t_string)), (), IcePy._t_string, (_M_Bank._t_UserAlreadyLoggedInException, _M_Bank._t_UserNotExistException, _M_Bank._t_IncorrectPasswordException))
    Account._op_logout = IcePy.Operation('logout', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, (), (), (), IcePy._t_bool, (_M_Bank._t_UserAlreadyLoggedOutException,))
    Account._op_getState = IcePy.Operation('getState', Ice.OperationMode.Idempotent, Ice.OperationMode.Idempotent, False, (), (), (), IcePy._t_int, (_M_Bank._t_UserNotLoggedIn,))
    Account._op_withdraw = IcePy.Operation('withdraw', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, (), (((), IcePy._t_int),), (), IcePy._t_int, (_M_Bank._t_UserNotLoggedIn, _M_Bank._t_InsufficientFundsException))
    Account._op_deposit = IcePy.Operation('deposit', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, (), (((), IcePy._t_int),), (), IcePy._t_bool, (_M_Bank._t_UserNotLoggedIn,))

    _M_Bank.Account = Account
    del Account

    _M_Bank.AccountPrx = AccountPrx
    del AccountPrx

if not _M_Bank.__dict__.has_key('Manager'):
    _M_Bank.Manager = Ice.createTempClass()
    class Manager(Ice.Object):
        def __init__(self):
            if __builtin__.type(self) == _M_Bank.Manager:
                raise RuntimeError('Bank.Manager is an abstract class')

        def ice_ids(self, current=None):
            return ('::Bank::Manager', '::Ice::Object')

        def ice_id(self, current=None):
            return '::Bank::Manager'

        def ice_staticId():
            return '::Bank::Manager'
        ice_staticId = staticmethod(ice_staticId)

        def register(self, PESEL, password, current=None):
            pass

        def __str__(self):
            return IcePy.stringify(self, _M_Bank._t_Manager)

        __repr__ = __str__

    _M_Bank.ManagerPrx = Ice.createTempClass()
    class ManagerPrx(Ice.ObjectPrx):

        def register(self, PESEL, password, _ctx=None):
            return _M_Bank.Manager._op_register.invoke(self, ((PESEL, password), _ctx))

        def begin_register(self, PESEL, password, _response=None, _ex=None, _sent=None, _ctx=None):
            return _M_Bank.Manager._op_register.begin(self, ((PESEL, password), _response, _ex, _sent, _ctx))

        def end_register(self, _r):
            return _M_Bank.Manager._op_register.end(self, _r)

        def checkedCast(proxy, facetOrCtx=None, _ctx=None):
            return _M_Bank.ManagerPrx.ice_checkedCast(proxy, '::Bank::Manager', facetOrCtx, _ctx)
        checkedCast = staticmethod(checkedCast)

        def uncheckedCast(proxy, facet=None):
            return _M_Bank.ManagerPrx.ice_uncheckedCast(proxy, facet)
        uncheckedCast = staticmethod(uncheckedCast)

    _M_Bank._t_ManagerPrx = IcePy.defineProxy('::Bank::Manager', ManagerPrx)

    _M_Bank._t_Manager = IcePy.defineClass('::Bank::Manager', Manager, (), True, None, (), ())
    Manager._ice_type = _M_Bank._t_Manager

    Manager._op_register = IcePy.Operation('register', Ice.OperationMode.Normal, Ice.OperationMode.Normal, False, (), (((), IcePy._t_string), ((), IcePy._t_string)), (), IcePy._t_bool, (_M_Bank._t_UserAlreadyExistException,))

    _M_Bank.Manager = Manager
    del Manager

    _M_Bank.ManagerPrx = ManagerPrx
    del ManagerPrx

# End of module Bank

__author__ = 'mateusz'
import sys, traceback
import Ice
import Bank

class Flow(object):

    def __init__(self):
#        Ice.Application.__init__(self)
        try:
            self.running = True
            self.session_token = None
            ic = Ice.initialize(sys.argv)
            base = ic.stringToProxy("Account:default -p 10000")
            self.account = Bank.AccountPrx.checkedCast(base)
            if not self.account:
                raise RuntimeError("Invalid proxy")
            base = ic.stringToProxy("Manager:default -p 10000")
            self.manager = Bank.ManagerPrx.checkedCast(base)
            if not self.manager:
                raise RuntimeError("Invalid proxy")
            self.actions_map = { "r": self.register,
                                 "l": self.login,
                                 "s": self.show_state,
                                 "d": self.deposit,
                                 "w": self.withdraw,
                                 "lo": self.logout,
                                 "q": self.quit}
        except:
            traceback.print_exc()
            sys.exit(-1)

    def run(self, args):
        self.flow()

    def flow(self):
        while self.running:
            print "What would you like to do: (r)egister new account, (l)ogin, (s)how account state, (d)eposit, (w)ithdraw, (lo)gout or (q)uit?"
            c = sys.stdin.read(1)
            sys.stdin.read(1)
            if self.actions_map.has_key(c):
                self.actions_map[c]()
            else:
                print "Wrong option"

    def register(self):
        print "Please give your PESEL"
        pesel = sys.stdin.readline()
        print "Please give your password"
        password = sys.stdin.readline()
        try:
            self.manager.register(pesel,password)
        except Ice.UserException as e:
            print e.description
            return
        print "Registration succeeded"

    def login(self):
        print "Please give your PESEL"
        pesel = sys.stdin.readline()
        print "Please give your password"
        password = sys.stdin.readline()
        try:
            self.session_token = self.account.login(pesel,password)
        except Ice.UserException as e:
            print e.description
            return
        print "You're logged in"

    def show_state(self):
        self.__action("Your funds: ",self.account.getState)

    def deposit(self):
        print "Please give stake to deposit"
        stake = int(sys.stdin.readline())
        self.__action("Your deposit succeeded - ",self.account.deposit,stake)

    def withdraw(self):
        print "Please give stake to withdraw"
        stake = int(sys.stdin.readline())
        self.__action("Withdrawal succeeded: ",self.account.withdraw,stake)

    def logout(self):
        self.__action("Logout succeeded: ",self.account.logout)

    def quit(self):
        sys.exit(0)

    def __action(self,message,action_name,stake=None):
        if not self.session_token:
            print "You're not logged in"
        else:
            ctx = {"token":self.session_token}
            try:
                if stake:
                    ret_value = action_name(stake,_ctx=ctx)
                else:
                    ret_value = action_name(_ctx=ctx)
                print message+str(ret_value)
            except Ice.UserException as e:
                print e.description

if __name__ == "__main__":
    status = Flow().flow()  #main(["BankClient"]+sys.argv,"config.client")
    sys.exit(status)



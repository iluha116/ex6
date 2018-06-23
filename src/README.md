shanich14
molodoy

==========================
=    File Description    =
==========================

Method.java - Class that represents container of data for creating method scope.
Sjavac.java - Class that represents the manager class of the program.
   It accepts a file with a code, and checks the property of it.
CodeException.java - Class that represents abstract class of exceptions that may be thrown in s-Java.
-----
IOExceptions-
InvalidNumOfArguments.java-
This is a sub-class of IOExceptions (exception that causes the program to end). It is 
   raised when the number of the input arguments is different then 2 (path of the source-directory,
   and path of the commands-file).
IOExceptions.java - That class represents IOExceptions that cause the program to end.
----------------------------------------------------------------------------------
Scopes:
Global.java - Class That represent the global scope of the code.
IfWhileScope.java - class  that represent the if and while scopes.
InnerScope.java - class that represent the if and while scopes. That can be inside the global scope.
MethodScope.java - Class that represent the method scope.
Scope.java - class that represents abstract scope in code. 
-----
Exceptions of Scope:
ScopeException.java - Class that represents abstract Exception that associated with illegal definition of scope.
InnerScopeHasNoEnd.java - Class that represents exception that thrown when some scope was defined without end.
   (number of '{' are not equal to '}' ).
RepeatMethodName.java - Class that represents exception thrown in case when Two methods was defined with the same name.

----------------------------------------------------------------------------------
Variables:
VariablesFactory.java - class that represents Variables Factory class
Variable.java - Class that represents interface Variable
BooleanVariable.java - Variable type boolean
StringVariable.java - Class that represents Variable type String
IntVariable.java - Class that represents Variable type Int.
FinalVariable.java - Class that represents final decorator(give to Variable an ability to be final).
DoubleVariable.java - Class that represents Variable type Double.
CharVariable.java - Class that represents Variable type Char.
-----
Exceptions of Variables:
VariableException - Class that represents abstract exception that associated to illegal actions with Variables.
WrongCastingException.java - Class that represents exception thrown in cases of illegal casting.
NoTypeOfVariable.java - Class that represents exception thrown in cases when variable was defined without a type.
FinalHasNoValue.java - Class that represents exception thrown in cases when final variable was defined without value.
ChangeFinalVariableException.java - Class that represents exception thrown
   in cases when there was an attempt to value of final variable
-----------------------------------------------------------------------------------
Lines:
Line.java - Class that represents Interface of Line of the code.
LineFactory.java - Class that represents Factory of lines .
---
VariableLine.java - Class that represents line that make some 
   action with variables,for example definition of variable or assignment value to some existed variable.
AssignmentVariableLine.java - Class that represents line that change or define value of some variable.
DefiningVariableLine.java - Class that represents line that define new variables.
---
IfWhileLine.java - Class that represents line that contain one of if/ while statements.
CallMethodLine.java - Class  that represent call for method line.
CommentsLine.java - Class  that represent comment and empty lines.
EndScope.java - Class that represents line that define new variables.
ReturnLine.java - Class that represent 'return;' line.
-----
Exceptions of the Lines:
IllegalLineException.java - Class that This class represents abstract 
   class of exception that associated with illegal definition of lines. 
CallMethodLineException.java - Class that represents 
   exception that thrown in case when call of method was made in illegal way.
CallToUnExistsParameter.java - Class that represents exception that 
   thrown in case when variable that is not exist called.
DefiningExistedVariableException.java - Class that represents exception that thrown in case when is
   defined new variable with name that already exists in the scope.
EndScopeException.java - Class that represents exception that thrown in case when char '}' was used in illegal way.
MethodCreatingException.java - Class that represents exception 
   that thrown in case when method created inside other method.
NoBooleanExpressionWhileCall.java - Class that represents exception that 
   thrown in case when if/while statement was is used with no boolean expression.
NotAppropriateLineFormatException.java - Class that represents exception 
   that thrown in case when string is not appropriate to existed patterns.
ParameterHasNoValue.java - Class that represents exception that thrown 
   in case when variable that was called have no value.
ReturnException.java - Class that This class represents exception that thrown in case when there
   was attempt to use return in illegal place.
SearchForUnExistsParameterException.java - Class that represents exception that thrown in case when there
   was attempt to use return in illegal place.

================
=    Design    =
================
We decided class Sjavac to be the main class. It does reading of the file,
transforming strings of array list of objects from type Line.
It does it in the next way:
Read string after string and send each of them to LineFactory. This factory
verify if transferred string is appropriate for one of existed patterns,and
if it is ,so create Line according to type of appropriate pattern . 
The string separated by groups to required types of information. 
Those groups are transferred to Constructor and created Line according 
to inserted parameters(if constructor is not default).
Created line is returned to Sjavac and added to Array list of lines.
And afterwards check each of the scopes separately.

Each of the scopes receive array list of lines and verify legality of each line.
In our version of task there is no Classes,so all founded scopes will be methods 
(if\while scopes will be detected during verification of methods.) 
Each line do it by itself-check if it is in appropriate scope,if all parameters (if such exist) are legal e.t.c.
If during verification of line correctness were founded block if or while will be also founded last line of the block
and this block will be verified in the same way as method.
If whole block is legal(if\while expression is legal and each of lines are pass verification)
verification of method will be continued. If inside if\while block other if\while block will be founded
it will be checked recursive (will be detected start and end of the block 
and verification of outward block will be continued if and only if inner block is legal).
If at least one of lines is illegal exception will be thrown (it could be thrown almost in any place)
and will be catched just in the Sjavac. Sjavac catch all types of exceptions and print messages according to task.
   
================================
=    Implementation details    =
================================


==============================
=    Answers to questions    =
==============================

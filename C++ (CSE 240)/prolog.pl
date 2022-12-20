/*Figure 1: Family Tree*/

/*parent rule, returns true if x is a parent of Y. */
parent(X,Y):-mother(X,Y).
parent(X,Y):-father(X,Y).

/*return true if both x and y have has the same parents*/
same_generation(X, Y) :- parent(Z, X), parent(Z, Y).

/*return true if they are descendants of a common ancestor*/
same_generation(X, Y) :- parent(U, X), parent(V, Y), sameGeneration(U, V).

/*the facts*/
mother(lisa, abe).
mother(lisa, sarah).
mother(nancy, john).
mother(mary, jill).
mother(sarah, susan).
mother(susan, jack).
mother(susan, phil).
father(tony, abe).
father(tony, sarah).
father(abe, john).
father(john, jill).
father(bill, susan).
father(rob, jack).
father(rob, phil).
father(jack, jim).




/*Tower of Hanoi*/

/*Moves the first disc from a to b*/
move(1, A, B, _) :- 
write('move top disk from '), 
write(A), 
write(' to '), 
write(B), 
nl.

/*Uses recursion to move discs*/
move(P, A, B, C) :- 
P > 1, 
S is P-1, 
move(S, A, C, B), 
move(1, A, B, _), 
move(S, C, B, A).




/*Predicate Sumlists*/

/*Reg Use*/
sumlists([], [], []).

/*if second list is empty*/
sumlists(L1, [], L1).

/*if third list is empty*/
sumlists([], L2, L2).

//splits head and tail, combines head, then uses recursion for tail. 
sumlists([H1|T1], [H2|T2], [H3|T3]) :- H3 is H1 + H2, sumlists(T1, T2, T3).




/*Extra Credit*/

solve([A, M, P, D, Y]) :- 
select(A,[0,1,2,3,4,5,6,7,8,9], WA), 
not(A = 0),
select(M,WA,WMA), 
select(P,WMA,WMAP), 
not(P=0), 
select(D,WMAP,WMAPD), 
not(D=0), 
select(Y,WMAPD,WMAPDY), 
DAY is 100*D+10*A+Y, 
AM  is 10*A+M, 
PM  is 10*P+M, 
DAY is AM+PM.
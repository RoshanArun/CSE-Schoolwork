/*Predicate Sumlists*/

/*Reg Use*/
sumlists([], [], []).

/*if second list is empty*/
sumlists(L1, [], L1).

/*if third list is empty*/
sumlists([], L2, L2).

//splits head and tail, combines head, then uses recursion for tail. */
sumlists([H1|T1], [H2|T2], [H3|T3]) :- H3 is H1 + H2, sumlists(T1, T2, T3).

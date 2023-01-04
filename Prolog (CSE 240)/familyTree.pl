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
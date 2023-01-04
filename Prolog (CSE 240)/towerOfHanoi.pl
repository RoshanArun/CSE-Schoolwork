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

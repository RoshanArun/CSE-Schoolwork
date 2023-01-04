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
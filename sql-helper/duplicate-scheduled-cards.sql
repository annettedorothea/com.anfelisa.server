delete from scheduledcard where scheduledcardid in( select scheduledcardid from (select countTable.count, c.cardid, scheduledcardid, scheduleddate, scoreddate, ROW_NUMBER() OVER(
    PARTITION BY c.cardid
    ORDER BY scheduleddate desc
) as rownumber from 
	(select count(cardid) as count, cardid from scheduledcard where quality is null group by cardid) as countTable 
	inner join scheduledcard c on c.cardid = countTable.cardid 
	where countTable.count > 1 and quality is null) as sub
	where rownumber > 1);
	
	select * from (select count(cardid) as count, cardid from scheduledcard where quality is null group by cardid) as countTable 
	inner join scheduledcard c on c.cardid = countTable.cardid order by countTable.count desc;

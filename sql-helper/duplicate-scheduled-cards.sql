delete  from scheduledcard where scheduledcardid in( 
select scheduledcardid from 
		(select countTable.count, sc.quality, sc.cardid, sc.boxid, scheduledcardid, scheduleddate, scoreddate, ROW_NUMBER() OVER(PARTITION BY sc.cardid ORDER BY scheduleddate desc) as rownumber from 
			(select count(cardid) as count, cardid, boxid from scheduledcard where quality is null group by cardid, boxid) as countTable 
			inner join scheduledcard sc on sc.cardid = countTable.cardid and sc.boxid = countTable.boxid	
		where countTable.count > 1 and quality is null) as sub
	inner join card c2 on c2.cardid = sub.cardid
	where rownumber > 1
)

select *  from scheduledcard where scheduledcardid in( 
select scheduledcardid from 
		(select countTable.count, sc.quality, sc.cardid, sc.boxid, scheduledcardid, scheduleddate, scoreddate, ROW_NUMBER() OVER(PARTITION BY sc.cardid ORDER BY scheduleddate desc) as rownumber from 
			(select count(cardid) as count, cardid, boxid from scheduledcard where quality is null group by cardid, boxid) as countTable 
			inner join scheduledcard sc on sc.cardid = countTable.cardid and sc.boxid = countTable.boxid	
		where countTable.count > 1 and quality is null) as sub
	inner join card c2 on c2.cardid = sub.cardid
	where rownumber > 1
)
order by cardid, boxid
	
	select * from (select count(cardid) as count, cardid from scheduledcard where quality is null group by cardid) as countTable 
	inner join scheduledcard c on c.cardid = countTable.cardid order by countTable.count desc;

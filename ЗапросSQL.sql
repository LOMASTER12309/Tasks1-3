select surname from stuff where experience = (select max(experience) from stuff 
where experience not in (select max(experience) from stuff));
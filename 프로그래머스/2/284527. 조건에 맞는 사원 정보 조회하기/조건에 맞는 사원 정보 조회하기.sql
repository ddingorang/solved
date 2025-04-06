SELECT 
    hg.score AS score,
    hg.emp_no AS emp_no,
    he.emp_name AS emp_name,
    he.position AS position,
    he.email AS email
FROM hr_employees he
LEFT JOIN (
    SELECT emp_no, SUM(score) AS score
    FROM hr_grade
    GROUP BY emp_no
) hg
ON he.emp_no = hg.emp_no
ORDER BY hg.score DESC
LIMIT 1;

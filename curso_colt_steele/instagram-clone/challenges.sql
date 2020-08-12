-- 1. Finding 5 oldest users
SELECT * 
FROM users
ORDER BY created_at ASC
LIMIT 5;

-- 2. Most Popular Registration Date
SELECT *, 
  COUNT(*) AS TOTAL,
  DAYNAME(created_at) as DAY
FROM users
GROUP BY DAY 
ORDER BY TOTAL DESC
LIMIT 3;

-- 3. Identify Inactive Users (users with no photos)
SELECT username
FROM users 
LEFT JOIN photos
ON users.id = photos.user_id
WHERE photos.id IS NULL;

-- 4. Identify most popular photo (and user who created it)
SELECT  
  users.username,
  photos.id,
  photos.image_url,
  COUNT(*) AS TOTAL
FROM photos
INNER JOIN likes
  ON likes.photo_id = photos.id
INNER JOIN users
  ON photos.user_id = users.id
GROUP BY photos.id
ORDER BY total DESC
LIMIT 1;

-- 5. Calculate avg number of photos per user
-- total numer of photos/total number of user
select
(select count(*) from photos) / (select count(*) from users)
AS avg_posts;

-- 6. Five most popular hashtags
  SELECT tags.tag_name, 
    count(*) as total
  FROM photo_tags 
  INNER JOIN tags
  ON photo_tags.tag_id = tags.id
  group by tags.id
  ORDER BY TOTAL DESC
  LIMIT 5;

-- 7. Finding Bots - users who have liked every single phto
SELECT  username, count(*) AS num_likes
FROM USERS
INNER JOIN likes
ON users.id = likes.user_id
GROUP BY likes.user_id
HAVING num_likes = (SELECT COUNT(*) FROM photos);
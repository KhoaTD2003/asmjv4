package com.poly.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.poly.dao.AbstracDAO;
import com.poly.dao.StatsDao;
import com.poly.dto.VideoLikedInfo;
import com.poly.util.NumberUtil;

public class StatsDaoImpl extends AbstracDAO<Object[]> implements StatsDao {

	@Override
	public List<VideoLikedInfo> findVideoLikedInfo() {
		String sql ="select v.id, v.title, v.href, count(isliked) as totallike"
				+ " from Video v left join History h on v.id = h.video.id"
				+ " where v.isActive = 1 and h.isLiked = 1" 
				+ " group by v.id, v.title, v.href"
				+ " order by totallike desc";	
		List<Object[]> objects = super.findManyByNativeQuery(sql);
		List<VideoLikedInfo> result = new ArrayList<>();
		objects.forEach(object-> {
			VideoLikedInfo videoLikedInfo = setDataVideoLikedInfo(object);
			
			result.add(videoLikedInfo);

		});
		return result;
	}
private VideoLikedInfo setDataVideoLikedInfo(Object[] object) {
	VideoLikedInfo videoLikedInfo = new VideoLikedInfo();
	videoLikedInfo.setVideoId((Integer)object[0]);
	videoLikedInfo.setTitle((String) object[1]);

	videoLikedInfo.setHref((String) object[2]);
	videoLikedInfo.setTotalLike(object[3]== null ?0 : NumberUtil.convertInt(object[3]));
return videoLikedInfo ;
}

 
	

}

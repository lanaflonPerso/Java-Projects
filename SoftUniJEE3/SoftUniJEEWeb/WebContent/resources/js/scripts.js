function cutText(content){
	
	if(content.length > 50){
		return content.substring(0, 50); 
	}
	return content;
}

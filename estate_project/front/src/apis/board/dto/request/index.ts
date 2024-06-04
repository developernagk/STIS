// description: Q&A 작성 Request Body DTO
export interface PostBoardRequestDto {
  title: string;
  contents: string;
}

export interface postCommentRequestDto {
  comment: string;
}

export interface putBoardRequestDto {
  title: string;
  contents: string;
}
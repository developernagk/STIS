import ResponseDto from "src/apis/response.dto";
import { BoardListItem } from "src/types";

export interface GerBoardListResponseDto extends ResponseDto {
  boardList: BoardListItem[];
}

export interface GetSearchBoardListResponseDto extends ResponseDto {
  boardList: BoardListItem[];
}
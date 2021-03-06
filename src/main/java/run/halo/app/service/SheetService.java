package run.halo.app.service;

import org.springframework.data.domain.Page;
import org.springframework.lang.NonNull;
import run.halo.app.model.dto.InternalSheetDTO;
import run.halo.app.model.entity.Sheet;
import run.halo.app.model.entity.SheetMeta;
import run.halo.app.model.enums.PostStatus;
import run.halo.app.model.vo.SheetDetailVO;
import run.halo.app.model.vo.SheetListVO;
import run.halo.app.service.base.BasePostService;

import java.util.List;
import java.util.Set;

/**
 * Sheet service interface.
 *
 * @author johnniang
 * @author ryanwang
 * @date 2019-04-24
 */
public interface SheetService extends BasePostService<Sheet> {

    /**
     * Creates a sheet.
     *
     * @param sheet    sheet must not be null
     * @param autoSave autoSave
     * @return created sheet
     */
    @NonNull
    Sheet createBy(@NonNull Sheet sheet, boolean autoSave);

    /**
     * Creates a sheet.
     *
     * @param sheet      sheet must not be null
     * @param sheetMetas sheet metas
     * @param autoSave   autoSave
     * @return created sheet
     */
    Sheet createBy(@NonNull Sheet sheet, Set<SheetMeta> sheetMetas, boolean autoSave);

    /**
     * Updates a sheet.
     *
     * @param sheet    sheet must not be null
     * @param autoSave autoSave
     * @return updated sheet
     */
    @NonNull
    Sheet updateBy(@NonNull Sheet sheet, boolean autoSave);

    /**
     * Updates a sheet.
     *
     * @param sheet      sheet must not be null
     * @param sheetMetas sheet metas
     * @param autoSave   autoSave
     * @return updated sheet
     */
    Sheet updateBy(@NonNull Sheet sheet, Set<SheetMeta> sheetMetas, boolean autoSave);

    /**
     * Gets by url
     *
     * @param status post status must not be null
     * @param url    post url must not be blank
     * @return sheet
     */
    @Override
    Sheet getBy(PostStatus status, String url);

    /**
     * Import sheet from markdown document.
     *
     * @param markdown markdown document.
     * @return imported sheet
     */
    @NonNull
    Sheet importMarkdown(@NonNull String markdown);

    /**
     * Export sheet to markdown file by sheet id.
     *
     * @param id sheet id
     * @return markdown file content
     */
    @NonNull
    String exportMarkdown(@NonNull Integer id);

    /**
     * Export sheet to markdown file by sheet.
     *
     * @param sheet current sheet
     * @return markdown file content
     */
    @NonNull
    String exportMarkdown(@NonNull Sheet sheet);

    /**
     * List internal sheets.
     *
     * @return list of internal sheets
     */
    @NonNull
    List<InternalSheetDTO> listInternal();

    /**
     * Converts to list dto page.
     *
     * @param sheetPage sheet page must not be nulls
     * @return a page of sheet list dto
     */
    @NonNull
    Page<SheetListVO> convertToListVo(@NonNull Page<Sheet> sheetPage);

    /**
     * Converts to detail vo.
     *
     * @param sheet sheet must not be null
     * @return sheet detail vo
     */
    @NonNull
    SheetDetailVO convertToDetailVo(@NonNull Sheet sheet);
}
